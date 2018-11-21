package Library.Model;

public class Option {
	private String title;
	private String method;
	private String rel;
	private String href;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Option() {
	}

	public Option(String title, String method, String rel, String href) {
		super();
		this.title = title;
		this.method = method;
		this.rel = rel;
		this.href = href;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getRel() {
		return rel;
	}

	public void setRel(String rel) {
		this.rel = rel;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}
}
