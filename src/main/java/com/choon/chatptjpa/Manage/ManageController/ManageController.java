// Source code is decompiled from a .class file using FernFlower decompiler.
package com.choon.chatptjpa.Manage.ManageController;

import com.choon.chatptjpa.Manage.ManageDTO.ImgEditRequestDTO;
import com.choon.chatptjpa.Manage.ManageDTO.MemberDTO;
import com.choon.chatptjpa.Manage.ManageDTO.Normal_memDTO;
import com.choon.chatptjpa.Manage.ManageDTO.PTeacherDTO;
import com.choon.chatptjpa.Manage.ManageDTO.StatusDTO;
import com.choon.chatptjpa.Manage.ManageDTO.UserDTO;
import com.choon.chatptjpa.Manage.ManageService.ManageService;
import com.choon.chatptjpa.Manage.ManageVO.ImgEditRequestVO;
import com.choon.chatptjpa.Manage.ManageVO.MemberVO;
import com.choon.chatptjpa.Manage.ManageVO.Normal_memVO;
import com.choon.chatptjpa.Manage.ManageVO.PTeacherVO;
import jakarta.transaction.Transactional;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManageController {
   @Autowired
   private ManageService mservice;

   public ManageController() {
   }

   public void del_member(String id) {
      this.mservice.delMember(id);
   }

   @GetMapping({"/norList"})
   public List<Normal_memDTO> normal_list() {
      return this.mservice.nor_memList();
   }


   // @GetMapping("/members")
   // public Page<MemberDTO> listMembers(@RequestParam(defaultValue = "0") int page,
   //                                     @RequestParam(defaultValue = "10") int size,
   //                                     @RequestParam(defaultValue = "id,asc") String[] sort) 
   // {
   //      Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
   //      return mservice.nor_memList(pageable);
   // }



   @DeleteMapping({"/nordel/{nnum}"})
   public ResponseEntity<?> delete_user(@PathVariable Integer nnum) {
      Optional<Normal_memVO> normalMem = this.mservice.getMemberNameByNnum(nnum);
      if (normalMem.isPresent()) {
         String memberName = ((Normal_memVO)normalMem.get()).getMemberName();
         this.mservice.delete_normal_mem(nnum);
         return ResponseEntity.ok().body("\uc774\ub984\uc774 '" + memberName + "'\uc774\uace0 \ubc88\ud638\uac00 " + nnum + "\uc778 \ud68c\uc6d0\uc774 \uc131\uacf5\uc801\uc73c\ub85c \uc0ad\uc81c\ub418\uc5c8\uc2b5\ub2c8\ub2e4.");
      } else {
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body("\ubc88\ud638\uac00 " + nnum + "\uc778 \ud68c\uc6d0\uc744 \ucc3e\uc744 \uc218 \uc5c6\uc2b5\ub2c8\ub2e4.");
      }
   }

   @GetMapping({"/ptmemList"})
   public List<PTeacherDTO> ptmember_list() {
      return this.mservice.pt_memList();
   }

   @GetMapping({"/yetList"})
   public List<PTeacherDTO> pt_applyList() {
      int a = 0;
      return this.mservice.pt_memListByStatus(a);
   }

   @GetMapping({"/ptmemList/{memberId}"})
   public ResponseEntity<List<PTeacherVO>> getPTeachersByMemberId(@PathVariable String memberId) {
      List<PTeacherVO> pTeachers = this.mservice.findByMemberId(memberId);
      return pTeachers != null && !pTeachers.isEmpty() ? ResponseEntity.ok(pTeachers) : ResponseEntity.noContent().build();
   }

   @DeleteMapping({"/ptdel/{tnum}"})
   public ResponseEntity<?> delete_pt(@PathVariable Integer tnum) {
      Optional<PTeacherVO> normalMem = this.mservice.getPtMeberNum(tnum);
      if (normalMem.isPresent()) {
         String memberName = ((PTeacherVO)normalMem.get()).getMemberName();
         this.mservice.delete_pt_mem(tnum);
         return ResponseEntity.ok().body("\uc774\ub984\uc774 '" + memberName + "'\uc774\uace0 \ubc88\ud638\uac00 " + tnum + "\uc778 \ud68c\uc6d0\uc774 \uc131\uacf5\uc801\uc73c\ub85c \uc0ad\uc81c\ub418\uc5c8\uc2b5\ub2c8\ub2e4.");
      } else {
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body("\ubc88\ud638\uac00 " + tnum + "\uc778 \ud68c\uc6d0\uc744 \ucc3e\uc744 \uc218 \uc5c6\uc2b5\ub2c8\ub2e4.");
      }
   }

   @GetMapping({"/allUsers"})
   public ResponseEntity<List<UserDTO>> getAllUsers() {
      List<UserDTO> users = this.mservice.getAllUsersWithDetails();
      return ResponseEntity.ok(users);
   }

   @GetMapping({"/allPTusers"})
   public ResponseEntity<List<UserDTO>> AllPtUsers() {
      List<UserDTO> users = this.mservice.AllPTeachers();
      return users.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(users);
   }

   @GetMapping({"/getunApplyUsers"})
   public ResponseEntity<List<UserDTO>> getunApplyUsers() {
      List<UserDTO> users = this.mservice.getUnapprovedPTeachers();
      return users.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(users);
   }

   @GetMapping({"/MembersDetails/{id}"})
   public ResponseEntity<List<UserDTO>> getMemberDetailById(@PathVariable("id") String id) {
      List<UserDTO> users = this.mservice.getUserDetails(id);
      return users != null ? ResponseEntity.ok(users) : ResponseEntity.notFound().build();
   }

   @GetMapping({"/MembersFind/{id}"})
   public ResponseEntity<Optional<MemberVO>> getfindMemberId(@PathVariable("id") String id) {
      Optional<MemberVO> users = this.mservice.getMemberId(id);
      return users != null ? ResponseEntity.ok(users) : ResponseEntity.notFound().build();
   }

   @GetMapping({"/getApplyUsers"})
   public ResponseEntity<List<UserDTO>> getApplyUsers() {
      List<UserDTO> users = this.mservice.getapprovedPTeachers();
      return users.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(users);
   }

   @PutMapping({"/updateTrainerStatus/{tnum}"})
   public ResponseEntity<?> updateTrainerStatus(@PathVariable Integer tnum, @RequestBody StatusDTO statusDTO) {
      PTeacherVO updatedTrainer = this.mservice.updateTrainerStatus(tnum, statusDTO.getStatus());
      return updatedTrainer != null ? ResponseEntity.ok().body("\uc131\uacf5\uc801.") : ResponseEntity.status(HttpStatus.NOT_FOUND).body("??: " + tnum);
   }

   @GetMapping({"/editList"})
   public ResponseEntity<List<ImgEditRequestDTO>> getAllEditImage() {
      List<ImgEditRequestDTO> i_list = this.mservice.getEditImg();
      return i_list == null ? ResponseEntity.noContent().build() : ResponseEntity.ok().body(i_list);
   }

   @PostMapping({"/deleteEditItems"})
   public ResponseEntity<List<ImgEditRequestDTO>> deleteItem(@RequestBody List<Long> id) {
      Iterator var2 = id.iterator();

      while(var2.hasNext()) {
         Long idx = (Long)var2.next();
         this.mservice.delEditImg(idx);
      }

      return ResponseEntity.ok().build();
   }

   
   @PostMapping({"/sendJsonFile"})
   public ResponseEntity<List<ImgEditRequestDTO>> sendJson(@RequestBody List<Long> id) {
      List<ImgEditRequestDTO> s_list = this.mservice.sendJson(id);
      return ResponseEntity.ok(s_list);
   }
   // @PostMapping("/deleteOneItem")
   // public void deleteOneItem(@RequestBody Long id)
   // {  
   //    mservice.delEditImg(id);
   // }
 





}
