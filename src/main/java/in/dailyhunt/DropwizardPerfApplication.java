package in.dailyhunt;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.MetricRegistry;
import in.dailyhunt.resources.SubSetResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

import java.util.concurrent.TimeUnit;

public class DropwizardPerfApplication extends Application<DropwizardPerfConfiguration> {

    private final static MetricRegistry metrics = new MetricRegistry();

    @Override
    public void run(DropwizardPerfConfiguration dropwizardPerfConfiguration, Environment environment) throws Exception {
        SubSetResource subSetResource = new SubSetResource(environment.getObjectMapper().getFactory());
        environment.jersey().register(subSetResource);
    }

    public static void main(String[] args) throws Exception{
        new DropwizardPerfApplication().run(args);
        //startReport();

    }

    private static  void startReport() {
        ConsoleReporter reporter = ConsoleReporter.forRegistry(metrics)
                .convertRatesTo(TimeUnit.SECONDS)
                .convertDurationsTo(TimeUnit.MILLISECONDS)
                .build();
        reporter.start(5, TimeUnit.SECONDS);
    }
}

