package entity;

public class Carousel {

	// �ֲ�ID
	private int indexId;
	// �ֲ�����
	private String indexTitle;
	// �ֲ�����
	private String indexDesc;
	// �ֲ�ͼƬ
	private String imageSrc;
	// �ֲ���ַ
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
