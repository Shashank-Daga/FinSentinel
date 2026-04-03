package com.finsentinel.repository;

import com.finsentinel.model.UserDevice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDeviceRepository extends JpaRepository<UserDevice, Long>{
    Optional<UserDevice> findByUserIdAndDeviceId(Long UserId, String deviceId);
}
