package entity;

public class Carousel {

	// ÂÖ²¥ID
	private int indexId;
	// ÂÖ²¥±êÌâ
	private String indexTitle;
	// ÂÖ²¥ÄÚÈİ
	private String indexDesc;
	// ÂÖ²¥Í¼Æ¬
	private String imageSrc;
	// ÂÖ²¥ÍøÖ·
	private String indexUrl;

	
	// SET|GET
	public int getIndexId() {
		return indexId;
	}

	public void setIndexId(int indexId) {
		this.indexId = indexId;
	}

	public String getIndexTitle() {
		return indexTitle;
	}

	public void setIndexTitle(String indexTitle) {
		this.indexTitle = indexTitle;
	}

	public String getIndexDesc() {
		return indexDesc;
	}

	public void setIndexDesc(String indexDesc) {
		this.indexDesc = indexDesc;
	}

	public String getImageSrc() {
		return imageSrc;
	}

	public void setImageSrc(String imageSrc) {
		this.imageSrc = imageSrc;
	}

	public String getIndexUrl() {
		return indexUrl;
	}

	public void setIndexUrl(String indexUrl) {
		this.indexUrl = indexUrl;
	}

}
