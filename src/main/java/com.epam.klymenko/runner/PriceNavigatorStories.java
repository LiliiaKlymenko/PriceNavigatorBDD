package com.epam.klymenko.runner;


import java.io.File;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.epam.klymenko.steps.CheckFilter;
import org.jbehave.core.Embeddable;
import org.jbehave.core.annotations.UsingEmbedder;
import org.jbehave.core.annotations.UsingSteps;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.failures.FailingUponPendingStep;
import org.jbehave.core.failures.SilentlyAbsorbingFailure;
import org.jbehave.core.i18n.LocalizedKeywords;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.AnnotatedEmbedderRunner;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.model.ExamplesTableFactory;
import org.jbehave.core.parsers.RegexStoryParser;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.core.steps.ParameterConverters;
import org.jbehave.core.steps.ParameterConverters.DateConverter;
import org.junit.runner.RunWith;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

/**
 * <p>
 * {@link Embeddable} class to run multiple textual stories via JUnit.
 * </p>
 * <p>
 * Stories are specified in classpath and correspondingly the {@link LoadFromClasspath} story loader is configured.
 * </p> 
 */

    @RunWith(AnnotatedEmbedderRunner.class)
    @UsingEmbedder(embedder = Embedder.class, generateViewAfterStories = true,
            ignoreFailureInStories = true, ignoreFailureInView = false,
            verboseFailures = true)
    @UsingSteps(instances = { CheckFilter.class })
    public class PriceNavigatorStories extends JUnitStories {

        @Override
        protected List<String> storyPaths() {
            return new StoryFinder().findPaths(
                    CodeLocations.codeLocationFromClass(getClass()).getFile(),
                    Arrays.asList(getStoryFilter("stories/CheckFilter.story")), null);
        }

        private String getStoryFilter(String storyPaths) {
            if (storyPaths == null) {
                return "*.story";
            }
            if (storyPaths.endsWith(".story")) {
                return storyPaths;
            }
            return storyPaths + ".story";
        }

        private List<String> specifiedStoryPaths(String storyPaths) {
            List<String> result = new ArrayList<String>();
            URI cwd = new File("src/test/resources").toURI();
            for (String storyPath : storyPaths.split(File.pathSeparator)) {
                File storyFile = new File(storyPath);
                if (!storyFile.exists()) {
                    throw new IllegalArgumentException("Story file not found: "
                            + storyPath);
                }
                result.add(cwd.relativize(storyFile.toURI()).toString());
            }
            return result;
        }

        @Override
        public Configuration configuration() {
            return super.configuration()
                    .useStoryReporterBuilder(new StoryReporterBuilder()
                                    .withFormats(Format.XML, Format.STATS, Format.CONSOLE)
                                    .withRelativeDirectory("../build/jbehave")
                    )
                    .usePendingStepStrategy(new FailingUponPendingStep())
                    .useFailureStrategy(new SilentlyAbsorbingFailure());
        }

    }