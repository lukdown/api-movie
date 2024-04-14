package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.dao.MovieDao;
import com.javaex.vo.MovieTimeVo;
import com.javaex.vo.MovieVo;
import com.javaex.vo.OrderItemVo;
import com.javaex.vo.OrderVo;
import com.javaex.vo.PointVo;

@Service
public class MovieService {

	@Autowired
	private MovieDao movieDao;

	
	public void exeOrder(OrderVo orderVo) {
		System.out.println("MovieDao.exeOrder()");
		
		int count= movieDao.insertRec(orderVo);
		
		
		for (OrderItemVo orderItem : orderVo.getOrderItemList()) {
			int m_r_no = orderVo.getM_r_no();
			orderItem.setM_r_no(m_r_no);
			
			movieDao.order(orderItem);
		}
		
		movieDao.usePoint(orderVo);
	}
	
	public List<PointVo> exeRec(int m_r_no) {
		System.out.println("MovieDao.exeRec()");

		List<PointVo> recList = movieDao.recSelect(m_r_no);

		return recList;
	}
	
	
	public int exePoint02(Map<String, String> params) {
		System.out.println("MovieService.exePoint02()");

		int point = movieDao.selectPoint02(params);

		return point;
	}
	
	public int exePoint(String phoneNumber) {
		System.out.println("MovieService.exePoint()");

		int point = movieDao.selectPoint(phoneNumber);

		return point;
	}
	
	
	// 1개 데이터 읽기
	public List<MovieTimeVo> exeSelectOne(int m_no) {
		System.out.println("MovieService.exeSelectOne()");

		List<MovieTimeVo> mVo = movieDao.movieSelectOne(m_no);

		return mVo;

	}

	
	// DB에 이미지 정보 저장
	public String exeUpload(MultipartFile file) {
		System.out.println("MovieService.exeUpload()");

		// 파일저장디렉토리
		String saveDir = "D:\\javaStudy\\upload";

		// (1)파일관련 정보 추출///////////////////////////////////////////////////

		// 오리지널 파일명
		String orgName = file.getOriginalFilename();
		System.out.println(orgName);

		// 확장자
		String exName = orgName.substring(orgName.lastIndexOf("."));
		System.out.println(exName);

		// 저장파일명(겹치지 않아야 된다)
		String saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + exName;
		System.out.println(saveName);

		// 파일사이즈
		long fileSize = file.getSize();
		System.out.println(fileSize);

		// 파일전체경로
		String filePath = saveDir + "\\" + saveName;
		System.out.println(filePath);

		// vo로묶기
		MovieVo movieVo = new MovieVo(filePath, orgName, saveName, fileSize);
		System.out.println(movieVo);

		// Dao만들기 --> DB저장 과제
		System.out.println(movieVo + "DB저장");

		movieDao.movieInsert(movieVo);

		// (2)파일을 하드디스크에 저장
		// 파일저장
		try {

			byte[] fileData = file.getBytes();

			OutputStream os = new FileOutputStream(filePath);
			BufferedOutputStream bos = new BufferedOutputStream(os);

			bos.write(fileData);
			bos.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return saveName;
	}
	

	// 영화 예매 리스트
	public List<MovieVo> exeMovieList() {
		System.out.println("MovieService.exeMovieList()");

		List<MovieVo> mList = movieDao.selectMovie();
		
		for (int i = 0; i < mList.size(); i++) {
			List<MovieTimeVo> mVo = movieDao.movieSelectOne(mList.get(i).getM_no());
			mList.get(i).settList(mVo);
			
		}
		System.out.println("======================================");
		System.out.println(mList);
		System.out.println("======================================");

		

		return mList;
	}
	// 영화 예매 리스트
	public List<MovieTimeVo> exeTimeList() {
		System.out.println("MovieService.exeMovieList()");
		
		List<MovieTimeVo> tList = movieDao.selectMovieTime();
		
		return tList;
	}

}