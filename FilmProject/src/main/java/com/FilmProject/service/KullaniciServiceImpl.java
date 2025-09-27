package com.FilmProject.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.FilmProject.dto.KullaniciRequestDTO;
import com.FilmProject.dto.KullaniciResponseDTO;
import com.FilmProject.dto.LoginRequestDTO;
import com.FilmProject.exception.EmailAlreadyExistsException;
import com.FilmProject.exception.UsernameAlreadyExistsException;
import com.FilmProject.model.KullaniciEntity;
import com.FilmProject.repository.KullaniciRepository;


@Service
public class KullaniciServiceImpl extends BaseServiceImpl implements KullaniciService {
	
	private final KullaniciRepository kullaniciRepository;
	private final PasswordEncoder encoder;
	
	public KullaniciServiceImpl(KullaniciRepository kullaniciRepository, PasswordEncoder encoder) {
		this.kullaniciRepository = kullaniciRepository;
		this.encoder = encoder;
	}
	
	@Override
	public List<KullaniciResponseDTO> getAllKullaniciEntities() {
		List<KullaniciEntity> kullaniciEntities = kullaniciRepository.findAll();
		return kullaniciEntities.stream().map(KullaniciResponseDTO::new).collect(Collectors.toList());
	}

	@Override
	public void register(KullaniciRequestDTO dto) {
		if (kullaniciRepository.existsByEmail(dto.getEmail())) 
			throw new EmailAlreadyExistsException(dto.getEmail());
		
		if (kullaniciRepository.existsByKullaniciAdi(dto.getKullaniciAdi())) 
			throw new UsernameAlreadyExistsException(dto.getKullaniciAdi());
		
		KullaniciEntity kullanici = new KullaniciEntity();
		kullanici.setAdi(dto.getAdi());
		kullanici.setSoyadi(dto.getSoyadi());
		kullanici.setKullaniciAdi(dto.getKullaniciAdi());
		kullanici.setEmail(dto.getEmail());
		kullanici.setSifre(encoder.encode(dto.getSifre()));
		kullanici.setRole(dto.getRol());
		kullanici.setDogumTarihi(dto.getDogumTarihi());
		kullanici.setOlusturmaZamani(LocalDateTime.now());
		
		kullaniciRepository.save(kullanici);
	}

	@Override
	public KullaniciEntity findByKullaniciAdi(String userName) {
		return kullaniciRepository.findByKullaniciAdi(userName).orElse(null);
	}

}
