package com.akhi.store.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.akhi.store.general.Products;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private DataSource dataSource;
	private static org.apache.log4j.Logger log = Logger
			.getLogger(ProductDaoImpl.class);

	@Override
	public Products findById(Long id, boolean lock) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Products> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Products> findByExample(Products exampleInstance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Products makePersistent(Products entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void makeTransient(Products entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Products> getProducts(int offset, int max) {

		Products result = null;
		ResultSet rs;
		Connection conn = null;
		List<Products> products = new ArrayList<Products>();
		try {
			conn = dataSource.getConnection();

			String sql = "SELECT PRODUCTS.COMPANY,PRODUCTS.PRODUCT_CODE,PRODUCTS.TYPE_OF_PRODUCT,PRODUCTS.PRODUCT_CATEGORY,PRODUCTS.PRODUCT_NAME,"
					+ " PRODUCTS.PACKING_TYPE,PRODUCTS.NET_WEIGHT,ITEM_PRICES.ITEM_PRICE"
					+ " FROM PRODUCTS"
					+ " LEFT JOIN ITEM_PRICES "
					+ " ON PRODUCTS.PRODUCT_CODE=ITEM_PRICES.ITEM_CODE"
					+ " limit " + offset + "," + max + "";

			log.info("Executing SQL " + sql);
			PreparedStatement ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs == null) {
				log.warn("Nothing found");
			} else {

				try {
					while (rs.next()) {
						result = new Products(rs.getString("COMPANY"),
								rs.getDouble("ITEM_PRICE"),
								rs.getString("PRODUCT_CODE"),
								rs.getString("TYPE_OF_PRODUCT"),
								rs.getString("PRODUCT_CATEGORY"),
								rs.getString("PACKING_TYPE"),
								rs.getString("PRODUCT_NAME"),
								rs.getDouble("NET_WEIGHT"));

						String image = getByImageId(result.getProduct_code());

						if (image != null) {
							result.setImage(image);
						}
						products.add(result);
					}

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			ps.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
		return products;
	}

	@Override
	public Products getById(String id) {

		Products result = null;
		ResultSet rs;
		Connection conn = null;

		try {
			conn = dataSource.getConnection();

			String sql = "SELECT PRODUCTS.COMPANY,PRODUCTS.PRODUCT_CODE,PRODUCTS.TYPE_OF_PRODUCT,PRODUCTS.PRODUCT_CATEGORY,PRODUCTS.PRODUCT_NAME,"
					+ " PRODUCTS.PACKING_TYPE,PRODUCTS.NET_WEIGHT,ITEM_PRICES.ITEM_PRICE"
					+ " FROM PRODUCTS"
					+ " LEFT JOIN ITEM_PRICES "
					+ " ON PRODUCTS.PRODUCT_CODE=ITEM_PRICES.ITEM_CODE"
					+ " where PRODUCT_CODE=?";

			log.info("Executing SQL " + sql);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if (rs == null) {
				log.warn("Nothing found");
			} else {

				try {
					while (rs.next()) {
						result = new Products(rs.getString("COMPANY"),
								rs.getDouble("ITEM_PRICE"),
								rs.getString("PRODUCT_CODE"),
								rs.getString("TYPE_OF_PRODUCT"),
								rs.getString("PRODUCT_CATEGORY"),
								rs.getString("PACKING_TYPE"),
								rs.getString("PRODUCT_NAME"),
								rs.getDouble("NET_WEIGHT"));

					}

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			ps.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}

		String image = getByImageId(result.getProduct_code());

		if (image != null)
			result.setImage(image);

		return result;
	}

	public String getByImageId(String id) {

		String result = null;
		ResultSet rs;
		Connection conn = null;

		try {
			conn = dataSource.getConnection();

			String sql = "SELECT * from IMAGES where code = ?";

			log.info("Executing SQL " + sql);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if (rs == null) {
				log.warn("getByImageId(): Image not found");
			} else {

				try {
					while (rs.next()) {
						result = rs.getString("IMAGE");
					}

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			ps.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
		return result;
	}

	@Override
	public Map<String, String> getCats() {

		ResultSet rs;
		Connection conn = null;
		Map<String, String> result = new HashMap<String, String>();
		try {
			conn = dataSource.getConnection();

			String sql = "SELECT * from PRODUCT_TYPES";

			log.info("Executing SQL " + sql);
			PreparedStatement ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs == null) {
				log.error("getCats(): Cats not found");
			} else {

				try {
					while (rs.next()) {
						result.put(rs.getString("TYPE_OF_PRODUCT"),
								rs.getString("NAME"));
					}

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			ps.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
		return result;
	}

	@Override
	public List<Products> getByCat(String cat, int offset, int max) {
		Products result = null;
		ResultSet rs;
		Connection conn = null;
		List<Products> products = new ArrayList<Products>();
		try {
			conn = dataSource.getConnection();

			String sql = "SELECT PRODUCTS.COMPANY,PRODUCTS.PRODUCT_CODE,PRODUCTS.TYPE_OF_PRODUCT,PRODUCTS.PRODUCT_CATEGORY,PRODUCTS.PRODUCT_NAME,"
					+ " PRODUCTS.PACKING_TYPE,PRODUCTS.NET_WEIGHT,ITEM_PRICES.ITEM_PRICE"
					+ " FROM PRODUCTS"
					+ " LEFT JOIN ITEM_PRICES "
					+ " ON PRODUCTS.PRODUCT_CODE=ITEM_PRICES.ITEM_CODE"
					+ " where TYPE_OF_PRODUCT=?"
					+ " limit "
					+ offset
					+ ","
					+ max + "";

			log.info("Executing SQL " + sql);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, cat);
			rs = ps.executeQuery();
			if (rs == null) {
				log.warn("Nothing found");
			} else {

				try {
					while (rs.next()) {
						result = new Products(rs.getString("COMPANY"),
								rs.getDouble("ITEM_PRICE"),
								rs.getString("PRODUCT_CODE"),
								rs.getString("TYPE_OF_PRODUCT"),
								rs.getString("PRODUCT_CATEGORY"),
								rs.getString("PACKING_TYPE"),
								rs.getString("PRODUCT_NAME"),
								rs.getDouble("NET_WEIGHT"));

						String image = getByImageId(result.getProduct_code());

						if (image != null) {
							result.setImage(image);
						}
						products.add(result);
					}

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			ps.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
		return products;
	}
}
