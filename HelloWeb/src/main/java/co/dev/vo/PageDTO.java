package co.dev.vo;

import lombok.Data;

@Data
public class PageDTO {
	private int startPage; // 첫페이지
	private int endpage; // 마지막 페이지
	private boolean prev, next; // 이전 페이지, 다음 페이지.
	private int page; // 현재페이지.

	public PageDTO(int page, int total) {
		// total: 235건.
		this.page = page;
		this.endpage = (int) Math.ceil(page / 10.0) * 10; // 1~10 => 10
		this.startPage = this.endpage - 9;

		int realEnd = (int) Math.ceil(total * 1.0 / 10);
		if (this.endpage > realEnd) {
			this.endpage = realEnd; // 22page 24
		}

		this.prev = this.startPage > 1;
		this.next = this.endpage < realEnd;// 3 -> 10
	}

}
