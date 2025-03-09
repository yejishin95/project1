package com.yeji.spring06.dto;

public class BoardDto {

		private int boardNo;
		private String boardTitle;
		private String boardContent;
		private String boardWriter;
		private int boardReadcount;
		@Override
		public String toString() {
			return "BoardDto [boardNo=" + boardNo + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent
					+ ", boardWriter=" + boardWriter + ", boardReadcount=" + boardReadcount + "]";
		}
		public int getBoardNo() {
			return boardNo;
		}
		public void setBoardNo(int boardNo) {
			this.boardNo = boardNo;
		}
		public String getBoardTitle() {
			return boardTitle;
		}
		public void setBoardTitle(String boardTitle) {
			this.boardTitle = boardTitle;
		}
		public String getBoardContent() {
			return boardContent;
		}
		public void setBoardContent(String boardContent) {
			this.boardContent = boardContent;
		}
		public String getBoardWriter() {
			return boardWriter;
		}
		public void setBoardWriter(String boardWriter) {
			this.boardWriter = boardWriter;
		}
		public int getBoardReadcount() {
			return boardReadcount;
		}
		public void setBoardReadcount(int boardReadcount) {
			this.boardReadcount = boardReadcount;
		}
		public BoardDto() {
			super();
		}
	
	
}
