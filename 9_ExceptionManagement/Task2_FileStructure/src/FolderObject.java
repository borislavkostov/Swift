
public class FolderObject extends FileObject {
	private String children;

	public FolderObject(String parent, String name, String children) {
		super(parent, name);
		this.children = children;
	}

	public String getChildren() {
		return children;
	}

	public void setChildren(String children) {
		this.children = children;
	}
}
