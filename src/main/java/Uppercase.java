import org.apache.beam.sdk.transforms.DoFn;

public class Uppercase extends DoFn<String, String> {
	  @ProcessElement
	  public void processElement(ProcessContext c) {
	    c.output(c.element().toUpperCase());
	  }
}