public class Color implements Cloneable{

	private short red, green, blue;
	
	public Color(int grey) {
		
		this.red = (short)grey;
		this.green = (short)grey;
		this.blue = (short)grey;
		
	}
	
	public Color(int red, int green, int blue) {
		
		this.red = (short)red;
		this.green = (short)green;
		this.blue = (short)blue;
		
	}

	public short getRed() {
		return red;
	}

	public void setRed(short red) {
		this.red = red;
	}

	public short getGreen() {
		return green;
	}

	public void setGreen(short green) {
		this.green = green;
	}

	public short getBlue() {
		return blue;
	}

	public void setBlue(short blue) {
		this.blue = blue;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + blue;
		result = prime * result + green;
		result = prime * result + red;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Color other = (Color) obj;
		if (blue != other.blue)
			return false;
		if (green != other.green)
			return false;
		if (red != other.red)
			return false;
		return true;
	}
	
	@Override
	public Color clone() {
		
		Color copia = null;
		
		try {
			
			copia = (Color)super.clone();
			
		}catch(CloneNotSupportedException error) { }
		
		return copia;
		
	}
	
	
}
