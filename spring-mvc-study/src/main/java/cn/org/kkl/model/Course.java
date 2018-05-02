package cn.org.kkl.model;

import java.io.Serializable;
import java.util.List;

public class Course implements Serializable {
	
	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + ", imgPath=" + imgPath + ", learningNum=" + learningNum
				+ ", duration=" + duration + ", level=" + level + ", levelDesc=" + levelDesc + ", descr=" + descr
				+ ", chapter=" + chapter + "]";
	}

	private Integer id;
	
	private String title;
	
	private String imgPath;
	
	private Integer learningNum;
	
	private Long duration;
	
	private Integer level;
	
	private String levelDesc;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public Integer getLearningNum() {
		return learningNum;
	}

	public void setLearningNum(Integer learningNum) {
		this.learningNum = learningNum;
	}

	public Long getDuration() {
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getLevelDesc() {
		return levelDesc;
	}

	public void setLevelDesc(String levelDesc) {
		this.levelDesc = levelDesc;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public List<Chapter> getChapter() {
		return chapter;
	}

	public void setChapter(List<Chapter> chapter) {
		this.chapter = chapter;
	}

	private String descr;
	
	private List<Chapter> chapter;

}
