package kr.pe.villagehero.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.pe.villagehero.dao.ErrandRepository;
import kr.pe.villagehero.dao.MemberRepository;
import kr.pe.villagehero.dto.ErrandDTO;
import kr.pe.villagehero.dto.MyPageDTO;
import kr.pe.villagehero.entity.Errand;
import kr.pe.villagehero.entity.Member;

@Service
public class ErrandService {

	@Autowired
	private ErrandRepository errandDAO;
	
	@Autowired
	private MemberRepository memberDAO;

	// 존재하는 모든 심부름을 DTO객체로 return
	public List<ErrandDTO> getAllErrands() {
		List<ErrandDTO> errandList = new ArrayList<ErrandDTO>();
		List<Errand> errands = (List<Errand>) errandDAO.findAll();

		errands.forEach(v -> errandList.add(new ErrandDTO(v)));

		return errandList;
	}

	public ErrandDTO getOneErrand(long id) {
		ErrandDTO errand = new ErrandDTO(errandDAO.findById(id).get());		
		return errand;
	}

	public String insertErrand(long id, ErrandDTO newErrand) {
		System.out.println("심부름 요청 등록시도");
		
		SimpleDateFormat dateFormat = new SimpleDateFormat ("yyyy-MM-dd");
		Date time = new Date();
	
		Member writer = memberDAO.findById(id).get() ; // session에서 받아와야함
    	int pay = newErrand.getPay();
    	String createdAt = dateFormat.format(time);
    	String title = newErrand.getTitle();
    	String content = newErrand.getContent();
    	String category = newErrand.getCategory();
    	String reqLocation = newErrand.getReqLocation();
    	String reqDate = newErrand.getReqDate();
    	char errandStatus = '0';

    	Errand errand = new Errand(writer, pay, createdAt, title, content, category, reqLocation, reqDate, errandStatus);

    	errandDAO.save(errand);
		return "심부름 요청 저장 성공";
	}

	// 존재하는 모든 심부름을 가격순(내림차순)으로 return
	public List<ErrandDTO> getAllErrandsPayDes() {
		List<ErrandDTO> all = new ArrayList<ErrandDTO>();
		List<Errand> all2 = (List<Errand>) errandDAO.findAll();

		all2.forEach(v -> all.add(new ErrandDTO(v)));
		all.sort(new PayComparator());
		return all;
	}

	
	
	//멤버 id 값으로 저장된 모든 심부름 find
	public List<MyPageDTO.ErrandDTO2> getAllMyErrands(Long memberId){
		Optional<Member> m = memberDAO.findById(memberId);
		List<MyPageDTO.ErrandDTO2> myreqlist = new ArrayList<>();
		
		m.ifPresent(member ->{
			List<Errand> sub = errandDAO.findAllMyReq(member);
			
			sub.forEach(v -> myreqlist.add(new MyPageDTO.ErrandDTO2(v.getTitle(),v.getErrandStatus())));
		});
		return myreqlist;
	}
	
	
	// 심부름 지원 (도와줄게요) - 심부름 상태 1 (매칭대기중)으로 변경
	public void updateErrandStatus(long errandId) {
		Errand e = errandDAO.findById(errandId).get();
		
		e.setErrandStatus('1');
		e.setCreatedAt(e.getCreatedAt().replace(" 00:00:00", ""));
		e.setCompletedAt(e.getCompletedAt().replace(" 00:00:00", ""));
		e.setReqDate(e.getReqDate().replace(" 00:00:00", ""));
		
		errandDAO.save(e);
	}
	
}


class PayComparator implements Comparator<ErrandDTO> {
	@Override
	public int compare(ErrandDTO a, ErrandDTO b) {
		if (a.getPay() > b.getPay())
			return -1;
		if (a.getPay() < b.getPay())
			return 1;
		return 0;
	}
}