// Source code is decompiled from a .class file using FernFlower decompiler.
package com.choon.chatptjpa.Manage.ManageService;

import com.choon.chatptjpa.Manage.ManageDTO.ImgEditRequestDTO;
import com.choon.chatptjpa.Manage.ManageDTO.MemberDTO;
import com.choon.chatptjpa.Manage.ManageDTO.Normal_memDTO;
import com.choon.chatptjpa.Manage.ManageDTO.PTeacherDTO;
import com.choon.chatptjpa.Manage.ManageDTO.UserDTO;
import com.choon.chatptjpa.Manage.ManageRepository.ImgEditRequestRepository;
import com.choon.chatptjpa.Manage.ManageRepository.MemberRepository;
import com.choon.chatptjpa.Manage.ManageRepository.Normal_mem_Repository;
import com.choon.chatptjpa.Manage.ManageRepository.PTeacherRepository;
import com.choon.chatptjpa.Manage.ManageVO.ImgEditRequestVO;
import com.choon.chatptjpa.Manage.ManageVO.MemberVO;
import com.choon.chatptjpa.Manage.ManageVO.Normal_memVO;
import com.choon.chatptjpa.Manage.ManageVO.PTeacherVO;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManageService {
   @Autowired
   private final MemberRepository memberRepository;
   @Autowired
   private final Normal_mem_Repository mRepository;
   @Autowired
   private final PTeacherRepository tRepository;
   @Autowired
   private final ImgEditRequestRepository imgRepository;

   public MemberVO create_member(MemberVO member) {
      MemberVO vo = MemberVO.builder().id(member.getId()).email(member.getEmail()).password(member.getPassword()).name(member.getName()).role(member.getRole()).gender(member.getGender()).birth(member.getBirth()).build();
      return (MemberVO)this.memberRepository.save(vo);
   }

   public List<MemberDTO> getMemberList() {
      List<MemberVO> listvo = this.memberRepository.findAll();
      List<MemberDTO> dtos = new ArrayList();
      Iterator var3 = listvo.iterator();

      while(var3.hasNext()) {
         MemberVO entity = (MemberVO)var3.next();
         MemberDTO dto = MemberDTO.builder().id(entity.getId()).name(entity.getName()).email(entity.getEmail()).password(entity.getPassword()).role(entity.getRole()).gender(entity.getGender()).birth(entity.getBirth()).build();
         dtos.add(dto);
      }

      return dtos;
   }

   public List<MemberVO> getMemberName(String name) {
      return this.memberRepository.findByName(name);
   }

   public Optional<MemberVO> getMemberId(String id) {
      return this.memberRepository.findById(id);
   }

   public void delMember(String id) {
      this.memberRepository.deleteById(id);
   }

   public List<Normal_memDTO> nor_memList() {
      List<Normal_memVO> normalMemList = this.mRepository.findAll();
      List<Normal_memDTO> dtos = new ArrayList();
      Iterator var3 = normalMemList.iterator();

      while(var3.hasNext()) {
         Normal_memVO entity = (Normal_memVO)var3.next();
         Normal_memDTO dto = Normal_memDTO.builder().nickname(entity.getNickname()).height(entity.getHeight()).weight(entity.getWeight()).activity(entity.getActivity()).purpose(entity.getPurpose()).normal_id(entity.getMemberId()).nnum(entity.getNnum()).build();
         dtos.add(dto);
      }

      return dtos;
   }

   public void delete_normal_mem(Integer nnum) {
      Normal_memVO dno = (Normal_memVO)this.mRepository.findById(nnum).orElseThrow(() -> {
         return new RuntimeException("\uc0ad\uc81c \ubd88\uac00\ub2a5");
      });
      MemberVO member = (MemberVO)this.memberRepository.findById(dno.getMemberId()).orElseThrow(() -> {
         return new RuntimeException("\ubabb\ucc3e\uc74c");
      });
      this.mRepository.delete(dno);
      this.memberRepository.delete(member);
   }

   public Normal_memVO update_normal_mem(Normal_memVO vo) {
      Normal_memVO result = (Normal_memVO)this.mRepository.findById(vo.getNnum()).orElseThrow(() -> {
         return new RuntimeException("\uc218\uc815 \ubd88\uac00\ub2a5");
      });
      result.setNickname(vo.getNickname());
      result.setHeight(vo.getHeight());
      result.setWeight(vo.getWeight());
      result.setActivity(vo.getActivity());
      result.setPurpose(vo.getPurpose());
      result.setNickname(vo.getNickname());
      return (Normal_memVO)this.mRepository.save(result);
   }

   public Optional<Normal_memVO> getMemberNameByNnum(Integer nnum) {
      return this.mRepository.findById(nnum);
   }

   @Transactional
   public void deleteNormalMemAndMember(Integer nnum) {
      this.mRepository.findById(nnum).ifPresent((normalMem) -> {
         this.memberRepository.delete(normalMem.getMember());
         this.mRepository.delete(normalMem);
      });
   }

   public List<PTeacherDTO> pt_memList() {
      List<PTeacherVO> normalMemList = this.tRepository.findAll();
      List<PTeacherDTO> dtos = new ArrayList();
      Iterator var3 = normalMemList.iterator();

      while(var3.hasNext()) {
         PTeacherVO entity = (PTeacherVO)var3.next();
         PTeacherDTO dto = PTeacherDTO.builder().trainer_id(entity.getMemberId()).trainerIntro(entity.getTrainerIntro()).trainerComment(entity.getTrainerComment()).address(entity.getAddress()).contactTime(entity.getContactTime()).awards(entity.getAwards()).awards1(entity.getAwards1()).awards2(entity.getAwards2()).awards3(entity.getAwards3()).awards4(entity.getAwards4()).status(entity.getStatus()).build();
         dtos.add(dto);
      }

      return dtos;
   }

   public List<PTeacherVO> findByMemberId(String id) {
      return this.tRepository.findByMemberId(id);
   }

   public Optional<PTeacherVO> getPtMeberNum(Integer nnum) {
      return this.tRepository.findById(nnum);
   }

   public List<PTeacherDTO> pt_memListByStatus(String status) {
      List<PTeacherVO> filteredMemList = this.tRepository.findByStatus(status);
      List<PTeacherDTO> dtos = new ArrayList();
      Iterator var4 = filteredMemList.iterator();

      while(var4.hasNext()) {
         PTeacherVO entity = (PTeacherVO)var4.next();
         PTeacherDTO dto = PTeacherDTO.builder().tnum(entity.getTnum()).trainer_id(entity.getMemberId()).trainerIntro(entity.getTrainerIntro()).trainerComment(entity.getTrainerComment()).address(entity.getAddress()).contactTime(entity.getContactTime()).awards(entity.getAwards()).awards1(entity.getAwards1()).awards2(entity.getAwards2()).awards3(entity.getAwards3()).awards4(entity.getAwards4()).status(entity.getStatus()).build();
         dtos.add(dto);
      }

      return dtos;
   }

   public void delete_pt_mem(Integer nnum) {
      PTeacherVO dno = (PTeacherVO)this.tRepository.findById(nnum).orElseThrow(() -> {
         return new RuntimeException("pt \uc0ad\uc81c \ubd88\uac00\ub2a5");
      });
      MemberVO member = (MemberVO)this.memberRepository.findById(dno.getMemberId()).orElseThrow(() -> {
         return new RuntimeException("\ubabb\ucc3e\uc74c");
      });
      this.tRepository.delete(dno);
      this.memberRepository.delete(member);
   }

   public List<UserDTO> getUserDetails(String id) {
      List<UserDTO> users = this.getAllUsersWithDetails();
      List<UserDTO> findUser = new ArrayList();
      Iterator var4 = users.iterator();

      while(var4.hasNext()) {
         UserDTO auser = (UserDTO)var4.next();
         if (auser.getUserid().equals(id)) {
            findUser.add(auser);
         }
      }

      return findUser;
   }

   public List<UserDTO> getAllUsersWithDetails() {
      List<UserDTO> users = new ArrayList();
      List<Normal_memVO> normalUsers = this.mRepository.findAll();
      Iterator var3 = normalUsers.iterator();

      while(var3.hasNext()) {
         Normal_memVO normalUser = (Normal_memVO)var3.next();
         UserDTO userDTO = new UserDTO();
         userDTO.setNnum(normalUser.getNnum());
         userDTO.setTnum((Integer)null);
         userDTO.setUserid(normalUser.getMember().getId());
         userDTO.setUsername(normalUser.getMember().getName());
         userDTO.setUsertype("\ud68c\uc6d0");
         userDTO.setUserstatus((String)null);
         users.add(userDTO);
      }

      List<PTeacherVO> pTeachers = this.tRepository.findAll();
      Iterator var9 = pTeachers.iterator();

      while(var9.hasNext()) {
         PTeacherVO teacher = (PTeacherVO)var9.next();
         UserDTO userDTO = new UserDTO();
         userDTO.setNnum((Integer)null);
         userDTO.setTnum(teacher.getTnum());
         userDTO.setUserid(teacher.getMember().getId());
         userDTO.setUsername(teacher.getMember().getName());
         userDTO.setUsertype("PT\uc120\uc0dd\ub2d8");
         userDTO.setUserstatus(teacher.getStatus());
         users.add(userDTO);
      }

      return users;
   }

   public List<UserDTO> AllPTeachers() {
      List<UserDTO> users = new ArrayList();
      List<PTeacherVO> allT = this.tRepository.findAll();
      Iterator var3 = allT.iterator();

      while(var3.hasNext()) {
         PTeacherVO teacher = (PTeacherVO)var3.next();
         UserDTO userDTO = new UserDTO();
         userDTO.setTnum(teacher.getTnum());
         userDTO.setUserid(teacher.getMember().getId());
         userDTO.setNnum((Integer)null);
         userDTO.setUsername(teacher.getMemberName());
         userDTO.setUsertype("PT\uc120\uc0dd\ub2d8");
         userDTO.setUserstatus(teacher.getStatus());
         users.add(userDTO);
      }

      return users;
   }

   public List<UserDTO> getUnapprovedPTeachers() {
      List<UserDTO> users = new ArrayList();
      List<PTeacherVO> unapprovedPTeachers = this.tRepository.findByStatus("\ubbf8\uc2b9\uc778");
      Iterator var3 = unapprovedPTeachers.iterator();

      while(var3.hasNext()) {
         PTeacherVO teacher = (PTeacherVO)var3.next();
         UserDTO userDTO = new UserDTO();
         userDTO.setTnum(teacher.getTnum());
         userDTO.setNnum((Integer)null);
         userDTO.setUserid(teacher.getMember().getId());
         userDTO.setUsername(teacher.getMemberName());
         userDTO.setUsertype("PT\uc120\uc0dd\ub2d8");
         userDTO.setUserstatus(teacher.getStatus());
         users.add(userDTO);
      }

      return users;
   }

   public List<UserDTO> getapprovedPTeachers() {
      List<UserDTO> users = new ArrayList();
      List<PTeacherVO> unapprovedPTeachers = this.tRepository.findByStatus("\uc2b9\uc778");
      Iterator var3 = unapprovedPTeachers.iterator();

      while(var3.hasNext()) {
         PTeacherVO teacher = (PTeacherVO)var3.next();
         UserDTO userDTO = new UserDTO();
         userDTO.setTnum(teacher.getTnum());
         userDTO.setUserid(teacher.getMember().getId());
         userDTO.setNnum((Integer)null);
         userDTO.setUsername(teacher.getMemberName());
         userDTO.setUsertype("PT\uc120\uc0dd\ub2d8");
         userDTO.setUserstatus(teacher.getStatus());
         users.add(userDTO);
      }

      return users;
   }

   public List<UserDTO> getfindPTuser(String id) {
      List<UserDTO> users = new ArrayList();
      List<PTeacherVO> unapprovedPTeachers = this.tRepository.findByMemberId(id);
      Iterator var4 = unapprovedPTeachers.iterator();

      while(var4.hasNext()) {
         PTeacherVO teacher = (PTeacherVO)var4.next();
         UserDTO userDTO = new UserDTO();
         userDTO.setTnum(teacher.getTnum());
         userDTO.setUserid(teacher.getMember().getId());
         userDTO.setNnum((Integer)null);
         userDTO.setUsername(teacher.getMemberName());
         userDTO.setUsertype("PT\uc120\uc0dd\ub2d8");
         userDTO.setUserstatus(teacher.getStatus());
         users.add(userDTO);
      }

      return users;
   }

   public PTeacherVO updateTrainerStatus(Integer tnum, String status) {
      Optional<PTeacherVO> trainerOptional = this.tRepository.findById(tnum);
      if (trainerOptional.isPresent()) {
         PTeacherVO trainer = (PTeacherVO)trainerOptional.get();
         trainer.setStatus(status);
         return (PTeacherVO)this.tRepository.save(trainer);
      } else {
         return null;
      }
   }

   public List<ImgEditRequestDTO> getEditImg() {
      List<ImgEditRequestVO> edit = this.imgRepository.findAll();
      List<ImgEditRequestDTO> result = new ArrayList();
      Iterator var3 = edit.iterator();

      while(var3.hasNext()) {
         ImgEditRequestVO vo = (ImgEditRequestVO)var3.next();
         ImgEditRequestDTO a = new ImgEditRequestDTO();
         a.setEditRequestId(vo.getEditRequestId());
         a.setImgEdit(vo.getImgEdit());
         a.setImgEditcomment(vo.getImgEditcomment());
         a.setUpPhotoId(vo.getUpPhotoId());
         a.setEditRequestStatus(vo.isEditRequestStatus());
         a.setBeforeData(vo.getBeforeData());
         a.setAfterData(vo.getAfterData());
         result.add(a);
      }

      return result;
   }

   @Transactional
   public void delEditImg(Long id) {
      ImgEditRequestVO dno = (ImgEditRequestVO)this.imgRepository.findById(id).orElseThrow(() -> {
         return new RuntimeException("\ubabb \ucc3e\uc74c");
      });
      this.imgRepository.delete(dno);
   }

   @Transactional
   public List<ImgEditRequestDTO> sendJson(List<Long> id) {
      List<ImgEditRequestDTO> alistz = new ArrayList();
      Iterator var3 = id.iterator();

      while(var3.hasNext()) {
         Long mid = (Long)var3.next();
         ImgEditRequestVO dio = (ImgEditRequestVO)this.imgRepository.findById(mid).orElseThrow(() -> {
            return new RuntimeException("\uc5c6\ub294\ub385?~!");
         });
         ImgEditRequestDTO result = new ImgEditRequestDTO();
         result.setEditRequestId(dio.getEditRequestId());
         result.setImgEdit(dio.getImgEdit());
         result.setAfterData(dio.getAfterData());
         result.setBeforeData(dio.getBeforeData());
         result.setEditRequestStatus(dio.isEditRequestStatus());
         result.setUpPhotoId(dio.getUpPhotoId());
         result.setImgEditcomment(dio.getImgEditcomment());
         alistz.add(result);
      }

      return alistz;
   }

   public String getRole(String userName) {
      return this.memberRepository.getRole(userName);
   }

   public String getNickname(String userName) {
      return this.memberRepository.getNickname(userName);
   }

   public String getName(String userName) {
      return this.memberRepository.getName(userName);
   }

   public ManageService(final MemberRepository memberRepository, final Normal_mem_Repository mRepository, final PTeacherRepository tRepository, final ImgEditRequestRepository imgRepository) {
      this.memberRepository = memberRepository;
      this.mRepository = mRepository;
      this.tRepository = tRepository;
      this.imgRepository = imgRepository;
   }
}
