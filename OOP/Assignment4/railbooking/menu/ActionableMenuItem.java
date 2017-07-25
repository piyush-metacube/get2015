package railbooking.menu;

public class ActionableMenuItem implements MenuItem {
	private Action action;
	private String displayText;

	@Override
	public void display() {
		System.out.println(displayText);
	}

	@Override
	public void takeAction() {
		action.perform();
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	public String getDisplayText() {
		return displayText;
	}

	public void setDisplayText(String displayText) {
		this.displayText = displayText;
	}
}
