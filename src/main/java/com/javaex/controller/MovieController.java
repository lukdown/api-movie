
package com.javaex.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.MovieService;
import com.javaex.util.JsonResult;
import com.javaex.vo.MovieTimeVo;
import com.javaex.vo.MovieVo;
import com.javaex.vo.OrderVo;
import com.javaex.vo.PointVo;

@RestController
public class MovieController {

	@Autowired
	private MovieService movieService;

	// 주문하기
	@PostMapping("/api/movie/order")
	public JsonResult order(@RequestBody OrderVo orderVo) {
		System.out.println("MovieController.order()");

		movieService.exeOrder(orderVo);

		int m_r_no = orderVo.getM_r_no();

		return JsonResult.success(m_r_no);
	}

	// 영수증 뽑기
	@GetMapping("/api/movie/rec")
	public JsonResult rec(@RequestParam int m_r_no) {
		System.out.println("MovieController.rec()");

		List<PointVo> recList = movieService.exeRec(m_r_no);
		System.out.println(recList);
		return JsonResult.success(recList);
	}

	// 포인트 조회(폰번호, 생년월일)
	@GetMapping("/api/movie/point02")
	public JsonResult pointUse(@RequestParam Map<String, String> params) {
		System.out.println("MovieController.pointUse()");
		int point = movieService.exePoint02(params);
		return JsonResult.success(point);
	}

	// 포인트 조회
	@GetMapping("/api/movie/point")
	public JsonResult point(@RequestParam String phoneNumber) {
		System.out.println("MovieController.point()");
		int point = movieService.exePoint(phoneNumber);
		return JsonResult.success(point);
	}

	

	// 영화 예매 리스트
	@GetMapping("/api/movie/list")
	public JsonResult movieList() {
		System.out.println("MovieController.movieList()");

		List<MovieVo> mList = movieService.exeMovieList();

		return JsonResult.success(mList);
	}

	@GetMapping("/api/movie/timelist")
	public JsonResult movieTimeList() {
		System.out.println("MovieController.movieList()");

		List<MovieTimeVo> tList = movieService.exeTimeList();

		return JsonResult.success(tList);
	}
	/*
	 * // 회원정보 수정폼(1명 데이터가져오기)
	 * 
	 * @GetMapping("/api/movie/count/{m_no}") public JsonResult
	 * movieCount(@PathVariable(value = "no") int m_no) {
	 * System.out.println("UserController.modifyform()");
	 * 
	 * 
	 * MovieVo movieVo = movieService.exeMovieCount(m_no);
	 * 
	 * return JsonResult.success(movieVo);
	 * 
	 * }
	 */
	
	
	// DB에 이미지 정보 저장
	
	@PostMapping("/api/movie/attach") public JsonResult upload(@RequestParam
	MultipartFile file, @ModelAttribute MovieVo movieVo) {
	System.out.println("MovieController.upload()");
	
	String saveName = movieService.exeUpload(file);
	
	return JsonResult.success(saveName); }
	

}
