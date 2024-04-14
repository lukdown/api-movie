package com.javaex.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.MovieTimeVo;
import com.javaex.vo.MovieVo;
import com.javaex.vo.OrderItemVo;
import com.javaex.vo.OrderVo;
import com.javaex.vo.PointVo;

@Repository
public class MovieDao {

	@Autowired
	private SqlSession sqlSession;

	public int usePoint(OrderVo orderVo) {
		System.out.println("MovieDao.usePoint()");
		System.out.println(orderVo);
		int point = sqlSession.update("movie.update", orderVo);

		return point;
	}
	
	public void order(OrderItemVo orderItem) {
	    System.out.println("MovieDao.order()");
	    
	    //sqlSession.insert("movie.order", orderItem);
	}
	
	
	public int insertRec(OrderVo orderVo) {
		System.out.println("MovieDao.insertRec()");
		int count = sqlSession.insert("movie.insertRec", orderVo);
		return count;
	}
	
	public List<PointVo> recSelect(int m_r_no) {
		System.out.println("MovieDao.recSelect()");

		List<PointVo> recList = sqlSession.selectList("movie.selectRec", m_r_no);
		System.out.println(recList);

		return recList;
	}
	
	
	public int selectPoint02(Map<String, String> params) {
		System.out.println("MovieDao.selectPoint02()");

		int point = sqlSession.selectOne("movie.usepoint", params);

		return point;
	}
	
	public int selectPoint(String phoneNumber) {
		System.out.println("MovieDao.selectPoint()");
		
		System.out.println(phoneNumber);
		int point = sqlSession.selectOne("movie.selectpoint", phoneNumber);

		return point;
	}
	
	// 데이터 1개 가져오기 no 1개 데이터 가져오기
	public List<MovieTimeVo> movieSelectOne(int m_no) {
		System.out.println("MovieDao..movieSelectOne()");
		
		//System.out.println(m_no);
		
		List<MovieTimeVo> mList = sqlSession.selectList("movie.selectTimeOneList", m_no);
		
		
		return mList;
	}

	// DB에 이미지 정보 저장
	public int movieInsert(MovieVo movieVo) {
		System.out.println("MovieDao.movieInsert()");

		int count = sqlSession.insert("movie.posterInsert", movieVo);

		return count;
	}

	// 영화 예매 리스트
	public List<MovieVo> selectMovie() {
		System.out.println("MovieDao.selectMovie()");

		List<MovieVo> mList = sqlSession.selectList("movie.selectMovieList");
		return mList;
	}
	// 영화 예매시간 리스트
	public List<MovieTimeVo> selectMovieTime() {
		System.out.println("MovieDao.selectMovie()");
		
		List<MovieTimeVo> tList = sqlSession.selectList("movie.selectTimeList");
		return tList;
	}

//	// no로 한명데이터 가져오기(회원정보수정 폼)
//	public MovieVo userSelectCount(int no) {
//		System.out.println("UserDao.userSelectOneByNo()");
//
//		MovieVo movieVo = sqlSession.selectOne("movie.selectMovieCount", no);
//		return movieVo;
//	}

}