
package com.ametis.cms.dao.impl;


import com.ametis.cms.datamodel.PolicyClausul;
import com.ametis.cms.dao.PolicyClausulDao;
import com.ametis.cms.util.dao.DaoSupportUtil;
import com.ametis.cms.util.*;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;

// imports+ 

// imports- 

/**
 * PolicyClausulDao adalah bean implementation untuk DAO tabel policy_clausul.
*/
public class PolicyClausulDaoImpl extends DaoSupportUtil implements PolicyClausulDao

// extends+ 

// extends- 
{
	

	/*
	* Method create (PolicyClausul object) berfungsi untuk melakukan penambahan
	* sebuah object kedalam database
	* @param object adalah sebuah object yang ingin diubah
	* @return object baru hasil create dengan assigned primary key , exception jika gagal
	*/
	public PolicyClausul create (PolicyClausul object) throws DataAccessException {
		this.getHibernateTemplate().save(object);
		return object;

	}
	/*
	* Method updatePolicyClausul (PolicyClausul object) berfungsi untuk melakukan perubahan terhadap
	* sebuah object yang terdapat didalam database
	* @param object adalah sebuah object yang ingin diubah
	* @return object hasil update apabila proses update berhasil dilakukan, dan exception jika gagal.
	*/
	public PolicyClausul update (PolicyClausul object) throws DataAccessException{
 	    this.getHibernateTemplate().update(object);
	    return object;
	}
	/*
	* Method delete (PolicyClausul object) berfungsi untuk melakukan penghapusan terhadap
	* sebuah object yang terdapat didalam database
	* @param object adalah sebuah object yang ingin dihapus, isi dari object tersebut cukup dengan
	*		 mengisi field-field primary key
	* @return no return value karena objeknya sendiri sudah dihapus - just for consistency. Again,
	* exception if fail
	*
	*/

	public PolicyClausul delete (PolicyClausul object) throws DataAccessException{
		this.getHibernateTemplate().delete(object);
		return object;
	}
	/*
	* Method get (PolicyClausul object) berfungsi untuk melakukan retrieval terhadap
	* sebuah object yang terdapat didalam database
	* @param object adalah sebuah object yang mempunyai ciri-ciri (example) sesuai dengan data yang diinginkan
	* @return Object yang dihasilkan dari proses retrieval, apabila object tidak ditemukan
	*	     maka method akan mengembalikan nilai "NULL"
	*/

	public PolicyClausul get (java.io.Serializable pkey) throws DataAccessException {
		return (PolicyClausul) this.getHibernateTemplate().get (PolicyClausul.class, pkey);
	}


/*
BASIC IMPLEMENTATION !! USE WITH CAUTION !
USE IT IF NO OTHER OPTION LEFT
@return criteria
*/
	public Criteria getCriteria() throws Exception {
		HibernateTemplate template = this.getHibernateTemplate();
		SessionFactory sessionFactory = template.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(PolicyClausul.class);
		return criteria;
	}

/*
BASIC IMPLEMENTATION !! USE WITH CAUTION !
USE IT IF NO OTHER OPTION LEFT
WARNING !! DONT" FORGET TO SET THE PROJECTION
example : detachedCriteria.setProjection(Property.forName("primary_key_field"));
@return DetachedCriteria
*
*/
	public DetachedCriteria getDetachedCriteria() throws Exception {
		DetachedCriteria dc = DetachedCriteria.forClass(PolicyClausul.class);
		return dc;
	}



//------------------------------------------------
// GAGAL TERUS -GAK SEMUA JALAN DENGAN BAIK - DINONAKTIFKAN
/*	public Collection searchPolicyClausul (PolicyClausul object) throws Exception{

		HibernateTemplate template = getHibernateTemplate();
		SessionFactory sessionFactory = template.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(PolicyClausul.class);
		criteria.add(Example.create(object));
		return criteria.list();
	}
*/
// class+ 

// class- 
}