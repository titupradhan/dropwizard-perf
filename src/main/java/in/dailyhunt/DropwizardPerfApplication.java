package in.dailyhunt;

import in.dailyhunt.resources.SubSetResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class DropwizardPerfApplication extends Application<DropwizardPerfConfiguration> {

    @Override
    public void run(DropwizardPerfConfiguration dropwizardPerfConfiguration, Environment environment) throws Exception {
        SubSetResource subSetResource = new SubSetResource();
        environment.jersey().register(subSetResource);
    }

    public static void main(String[] args) throws Exception{
        new DropwizardPerfApplication().run(args);
    }
}
