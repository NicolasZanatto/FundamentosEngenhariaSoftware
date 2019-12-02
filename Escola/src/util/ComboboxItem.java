package util;

public class ComboboxItem {
	
	public String text;
	public int value;
	
	
	public ComboboxItem(int value, String text) {
		this.value = value;
		this.text = text;
	}
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
	
	@Override
    public String toString() {
       return text;
   }
}
