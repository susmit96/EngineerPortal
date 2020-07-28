package com.sysenc.portal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sysenc.portal.model.EngineerInformation;
import com.sysenc.portal.repository.EngineerInformationRepository;
import com.sysenc.portal.view.EngineerInformationViewModel;

@Service
public class EngineerInformationService {

	@Autowired
	private EngineerInformationRepository engineerInformationRepository;

	public Page<EngineerInformation> initView(int pageNumber,String fullName, String address) {
		Pageable pageable = PageRequest.of(pageNumber - 1,10);

//		if(fullName!=null || address!=null || comment!=null) {
//			return engineerInformationRepository.findAll(fullName,address,comment,pageable);
//		}

		if(fullName==null && address==null) {
			return engineerInformationRepository.findAll(pageable);
		}

		return engineerInformationRepository.findByFullNameOrAddressContaining(fullName,address,pageable);

	}

	public void show(EngineerInformationViewModel engineerInformationViewModel) {
		EngineerInformation ei = engineerInformationRepository.findByEngineerId(engineerInformationViewModel.getEngineerId());
		engineerInformationViewModel.setEngineerInfo(ei);
	}

//	public void search(EngineerInformationViewModel engineerInformationViewModel) {
//		List<EngineerInformation> ei = engineerInformationRepository.findAll(engineerInformationViewModel.getName(),engineerInformationViewModel.getAddress(),engineerInformationViewModel.getComment());
//		engineerInformationViewModel.setEngineerInfoList(ei);
//	}

}
