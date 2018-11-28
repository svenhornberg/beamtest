import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.ParDo;
import org.joda.time.Duration;

public class Main {

	public static void main(String[] args) {

		System.out.println("Start");

		PipelineOptions options = PipelineOptionsFactory.create();

		Pipeline pipeline = Pipeline.create(options);

		pipeline
		.apply(TextIO.read().from(System.getProperty("user.dir") + "/src/main/Files/*.txt"))
		.apply(ParDo.of(new Uppercase()))
		.apply(TextIO.write().to("wordcounts.text"));

		pipeline.run().waitUntilFinish(Duration.standardSeconds(10));

		System.out.println("End");

		String workingDir = System.getProperty("user.dir");
		System.out.println("Current working directory : " + workingDir);
	}
}
å