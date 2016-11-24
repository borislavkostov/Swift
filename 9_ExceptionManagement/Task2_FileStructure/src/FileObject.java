
public class FileObject extends FileSystemObject{
	public FileObject(String parent,String name){
		super(parent,name);
	}
	@Override
	public void setName(String name){
		String[] extn = name.trim().split(".");
		if(extn.length<0||extn.length>6){
			throw (new IllegalArgumentException("Invalid name specified"));
		}
	}
}
