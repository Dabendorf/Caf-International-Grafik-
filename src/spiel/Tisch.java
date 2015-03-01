package spiel;

import java.util.Arrays;

public class Tisch {
	
	private Laenderkarte land;
    private Stuhl[] stuhl;
    private int x, y;
    private Spielzelle sz;

	@Override
	public String toString() {
		return "Tisch [land=" + land + ", stuhl=" + Arrays.toString(stuhl)
				+ ", x=" + x + ", y=" + y + ", sz=" + sz + "]";
	}
    
	public Laenderkarte getLand() {
		return land;
	}
	public void setLand(Laenderkarte land) {
		this.land = land;
	}
	public Stuhl[] getStuehle() {
		return stuhl;
	}
	public void setStuehle(Stuhl... stuhl) {
		this.stuhl = stuhl;
	}

	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

	public void setKoord(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Spielzelle getSz() {
		return sz;
	}

	public void setSz(Spielzelle sz) {
		this.sz = sz;
	}

}