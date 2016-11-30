import java.util.List;
import java.util.ArrayList;

public class Snake {
	private List<Dot> body = new ArrayList<>();

	public void eatApple(Dot dot) {
		this.body.add(dot);
	}

	public List<Dot> getBody() {
		return body;
	}

	public void setBody(List<Dot> body) {
		this.body = body;
	}

}
