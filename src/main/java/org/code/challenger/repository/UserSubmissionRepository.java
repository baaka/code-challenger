package org.code.challenger.repository;

import org.code.challenger.domain.UserSubmission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserSubmissionRepository extends JpaRepository<UserSubmission, Long> {
}
