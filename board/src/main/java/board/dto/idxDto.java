package board.dto;

public class idxDto {
	
	private int Idx;

	public int getIdx() {
		return Idx;
	}

	public void setIdx(int idx) {
		Idx = idx;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("idxDto [Idx=");
		builder.append(Idx);
		builder.append("]");
		return builder.toString();
	}
	
	

}
