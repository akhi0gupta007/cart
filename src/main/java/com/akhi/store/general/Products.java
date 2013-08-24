package com.akhi.store.general;

import java.util.Date;

public class Products {

	private String company;

	private Double price;

	private String product_code;

	private String type_product;

	private String product_cat;

	private String brand_code;

	private String um_code;

	private String price_cat;

	private String packing;

	private String product_name;

	private String product_other_name;

	private String default_name;

	private String description;

	private String old_product_code;

	private Double gross_weight;

	private Double net_weight;

	private Double max_level;

	private Double reorder_level;

	private Double reorder_quan;

	private String abc_code;

	private String ved_code;

	private String high_value_flag;

	private Double total_stock_qty;

	private Double total_stock_value;

	private String month_opening_qty;

	private Double month_opening_value;

	private Double year_opening_qty;

	private Double year_opening_val;

	private String type_sale;

	private String status;

	private String created_by;

	private Date created_on;

	private String last_updated_by;

	private Date last_upd_on;

	private String local_sale_gl_code;

	private String local_sale_gl_sub_code;

	private String export_sale_gl_code;

	private String export_sale_gl_sub_code;

	private String packing_size_code;

	private String ref_product_code;

	private int print_seq_no;

	private String schedule_no;

	private String hsn_code;

	private String k_entry_no;

	private String business_line;

	private String product_classification;

	private int cases_size;

	public Products(String company, Double price, String product_code,
			String type_product, String product_cat, String packing,
			String product_name, Double net_weight) {
		super();
		this.company = company;
		this.price = price;
		this.product_code = product_code;
		this.type_product = type_product;
		this.product_cat = product_cat;
		this.packing = packing;
		this.product_name = product_name;
		this.net_weight = net_weight;
	}

	@Override
	public String toString() {
		return "Products [company=" + company + ", price=" + price
				+ ", product_code=" + product_code + ", type_product="
				+ type_product + ", product_cat=" + product_cat
				+ ", brand_code=" + brand_code + ", um_code=" + um_code
				+ ", price_cat=" + price_cat + ", packing=" + packing
				+ ", product_name=" + product_name + ", product_other_name="
				+ product_other_name + ", default_name=" + default_name
				+ ", description=" + description + ", old_product_code="
				+ old_product_code + ", gross_weight=" + gross_weight
				+ ", net_weight=" + net_weight + ", max_level=" + max_level
				+ ", reorder_level=" + reorder_level + ", reorder_quan="
				+ reorder_quan + ", abc_code=" + abc_code + ", ved_code="
				+ ved_code + ", high_value_flag=" + high_value_flag
				+ ", total_stock_qty=" + total_stock_qty
				+ ", total_stock_value=" + total_stock_value
				+ ", month_opening_qty=" + month_opening_qty
				+ ", month_opening_value=" + month_opening_value
				+ ", year_opening_qty=" + year_opening_qty
				+ ", year_opening_val=" + year_opening_val + ", type_sale="
				+ type_sale + ", status=" + status + ", created_by="
				+ created_by + ", created_on=" + created_on
				+ ", last_updated_by=" + last_updated_by + ", last_upd_on="
				+ last_upd_on + ", local_sale_gl_code=" + local_sale_gl_code
				+ ", local_sale_gl_sub_code=" + local_sale_gl_sub_code
				+ ", export_sale_gl_code=" + export_sale_gl_code
				+ ", export_sale_gl_sub_code=" + export_sale_gl_sub_code
				+ ", packing_size_code=" + packing_size_code
				+ ", ref_product_code=" + ref_product_code + ", print_seq_no="
				+ print_seq_no + ", schedule_no=" + schedule_no + ", hsn_code="
				+ hsn_code + ", k_entry_no=" + k_entry_no + ", business_line="
				+ business_line + ", product_classification="
				+ product_classification + ", cases_size=" + cases_size
				+ ", buss_code=" + buss_code + "]";
	}

	private String buss_code;

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getProduct_code() {
		return product_code;
	}

	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}

	public String getType_product() {
		return type_product;
	}

	public void setType_product(String type_product) {
		this.type_product = type_product;
	}

	public String getProduct_cat() {
		return product_cat;
	}

	public void setProduct_cat(String product_cat) {
		this.product_cat = product_cat;
	}

	public String getBrand_code() {
		return brand_code;
	}

	public void setBrand_code(String brand_code) {
		this.brand_code = brand_code;
	}

	public String getUm_code() {
		return um_code;
	}

	public void setUm_code(String um_code) {
		this.um_code = um_code;
	}

	public String getPrice_cat() {
		return price_cat;
	}

	public void setPrice_cat(String price_cat) {
		this.price_cat = price_cat;
	}

	public String getPacking() {
		return packing;
	}

	public void setPacking(String packing) {
		this.packing = packing;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_other_name() {
		return product_other_name;
	}

	public void setProduct_other_name(String product_other_name) {
		this.product_other_name = product_other_name;
	}

	public String getDefault_name() {
		return default_name;
	}

	public void setDefault_name(String default_name) {
		this.default_name = default_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOld_product_code() {
		return old_product_code;
	}

	public void setOld_product_code(String old_product_code) {
		this.old_product_code = old_product_code;
	}

	public Double getGross_weight() {
		return gross_weight;
	}

	public void setGross_weight(Double gross_weight) {
		this.gross_weight = gross_weight;
	}

	public Double getNet_weight() {
		return net_weight;
	}

	public void setNet_weight(Double net_weight) {
		this.net_weight = net_weight;
	}

	public Double getMax_level() {
		return max_level;
	}

	public void setMax_level(Double max_level) {
		this.max_level = max_level;
	}

	public Double getReorder_level() {
		return reorder_level;
	}

	public void setReorder_level(Double reorder_level) {
		this.reorder_level = reorder_level;
	}

	public Double getReorder_quan() {
		return reorder_quan;
	}

	public void setReorder_quan(Double reorder_quan) {
		this.reorder_quan = reorder_quan;
	}

	public String getAbc_code() {
		return abc_code;
	}

	public void setAbc_code(String abc_code) {
		this.abc_code = abc_code;
	}

	public String getVed_code() {
		return ved_code;
	}

	public void setVed_code(String ved_code) {
		this.ved_code = ved_code;
	}

	public String getHigh_value_flag() {
		return high_value_flag;
	}

	public void setHigh_value_flag(String high_value_flag) {
		this.high_value_flag = high_value_flag;
	}

	public Double getTotal_stock_qty() {
		return total_stock_qty;
	}

	public void setTotal_stock_qty(Double total_stock_qty) {
		this.total_stock_qty = total_stock_qty;
	}

	public Double getTotal_stock_value() {
		return total_stock_value;
	}

	public void setTotal_stock_value(Double total_stock_value) {
		this.total_stock_value = total_stock_value;
	}

	public String getMonth_opening_qty() {
		return month_opening_qty;
	}

	public void setMonth_opening_qty(String month_opening_qty) {
		this.month_opening_qty = month_opening_qty;
	}

	public Double getMonth_opening_value() {
		return month_opening_value;
	}

	public void setMonth_opening_value(Double month_opening_value) {
		this.month_opening_value = month_opening_value;
	}

	public Double getYear_opening_qty() {
		return year_opening_qty;
	}

	public void setYear_opening_qty(Double year_opening_qty) {
		this.year_opening_qty = year_opening_qty;
	}

	public Double getYear_opening_val() {
		return year_opening_val;
	}

	public void setYear_opening_val(Double year_opening_val) {
		this.year_opening_val = year_opening_val;
	}

	public String getType_sale() {
		return type_sale;
	}

	public void setType_sale(String type_sale) {
		this.type_sale = type_sale;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public Date getCreated_on() {
		return created_on;
	}

	public void setCreated_on(Date created_on) {
		this.created_on = created_on;
	}

	public String getLast_updated_by() {
		return last_updated_by;
	}

	public void setLast_updated_by(String last_updated_by) {
		this.last_updated_by = last_updated_by;
	}

	public Date getLast_upd_on() {
		return last_upd_on;
	}

	public void setLast_upd_on(Date last_upd_on) {
		this.last_upd_on = last_upd_on;
	}

	public String getLocal_sale_gl_code() {
		return local_sale_gl_code;
	}

	public void setLocal_sale_gl_code(String local_sale_gl_code) {
		this.local_sale_gl_code = local_sale_gl_code;
	}

	public String getLocal_sale_gl_sub_code() {
		return local_sale_gl_sub_code;
	}

	public void setLocal_sale_gl_sub_code(String local_sale_gl_sub_code) {
		this.local_sale_gl_sub_code = local_sale_gl_sub_code;
	}

	public String getExport_sale_gl_code() {
		return export_sale_gl_code;
	}

	public void setExport_sale_gl_code(String export_sale_gl_code) {
		this.export_sale_gl_code = export_sale_gl_code;
	}

	public String getExport_sale_gl_sub_code() {
		return export_sale_gl_sub_code;
	}

	public void setExport_sale_gl_sub_code(String export_sale_gl_sub_code) {
		this.export_sale_gl_sub_code = export_sale_gl_sub_code;
	}

	public String getPacking_size_code() {
		return packing_size_code;
	}

	public void setPacking_size_code(String packing_size_code) {
		this.packing_size_code = packing_size_code;
	}

	public String getRef_product_code() {
		return ref_product_code;
	}

	public void setRef_product_code(String ref_product_code) {
		this.ref_product_code = ref_product_code;
	}

	public int getPrint_seq_no() {
		return print_seq_no;
	}

	public void setPrint_seq_no(int print_seq_no) {
		this.print_seq_no = print_seq_no;
	}

	public String getSchedule_no() {
		return schedule_no;
	}

	public void setSchedule_no(String schedule_no) {
		this.schedule_no = schedule_no;
	}

	public String getHsn_code() {
		return hsn_code;
	}

	public void setHsn_code(String hsn_code) {
		this.hsn_code = hsn_code;
	}

	public String getK_entry_no() {
		return k_entry_no;
	}

	public void setK_entry_no(String k_entry_no) {
		this.k_entry_no = k_entry_no;
	}

	public String getBusiness_line() {
		return business_line;
	}

	public void setBusiness_line(String business_line) {
		this.business_line = business_line;
	}

	public String getProduct_classification() {
		return product_classification;
	}

	public void setProduct_classification(String product_classification) {
		this.product_classification = product_classification;
	}

	public int getCases_size() {
		return cases_size;
	}

	public void setCases_size(int cases_size) {
		this.cases_size = cases_size;
	}

	public String getBuss_code() {
		return buss_code;
	}

	public void setBuss_code(String buss_code) {
		this.buss_code = buss_code;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
