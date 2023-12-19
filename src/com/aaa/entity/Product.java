package com.aaa.entity;

public class Product{

 private int pid;

 private String pname;

 private double marketPrice;

 private double shopPrice;

 private String pimage;

 private int isHot;

 private String pdesc;

 private int pflag;

 private String cid;

 private int collect;

 private String desc;

 public Product() {

}
 
 public Product (int pid, String pname, double marketPrice, double shopPrice, String pimage, int isHot, String pdesc, int pflag, String cid, int collect, String desc) {
this.pid = pid;
this.pname = pname;
this.marketPrice = marketPrice;
this.shopPrice = shopPrice;
this.pimage = pimage;
this.isHot = isHot;
this.pdesc = pdesc;
this.pflag = pflag;
this.cid = cid;
this.collect = collect;
this.desc = desc;
}
 public void setPid(int pid) {
	    this.pid = pid;
 }

 public int getPid() {
		return pid;
}

 public void setPname(String pname) {
	    this.pname = pname;
 }

 public String getPname() {
		return pname;
}

 public void setMarketPrice(double marketPrice) {
	    this.marketPrice = marketPrice;
 }

 public double getMarketPrice() {
		return marketPrice;
}

 public void setShopPrice(double shopPrice) {
	    this.shopPrice = shopPrice;
 }

 public double getShopPrice() {
		return shopPrice;
}

 public void setPimage(String pimage) {
	    this.pimage = pimage;
 }

 public String getPimage() {
		return pimage;
}

 public void setIsHot(int isHot) {
	    this.isHot = isHot;
 }

 public int getIsHot() {
		return isHot;
}

 public void setPdesc(String pdesc) {
	    this.pdesc = pdesc;
 }

 public String getPdesc() {
		return pdesc;
}

 public void setPflag(int pflag) {
	    this.pflag = pflag;
 }

 public int getPflag() {
		return pflag;
}

 public void setCid(String cid) {
	    this.cid = cid;
 }

 public String getCid() {
		return cid;
}

 public void setCollect(int collect) {
	    this.collect = collect;
 }

 public int getCollect() {
		return collect;
}

 public void setDesc(String desc) {
	    this.desc = desc;
 }

 public String getDesc() {
		return desc;
}

 public String toString() {
 return "Product [pid=" + pid + ", pname=" + pname + ", marketPrice=" + marketPrice + 
", shopPrice=" + shopPrice + ", pimage=" + pimage + ", isHot=" + isHot + 
", pdesc=" + pdesc + ", pflag=" + pflag + ", cid=" + cid + 
", collect=" + collect + ", desc=" + desc + "]";
}
}
