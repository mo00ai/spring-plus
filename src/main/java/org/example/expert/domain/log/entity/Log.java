package org.example.expert.domain.log.entity;

import java.time.LocalDateTime;

import org.example.expert.domain.manager.entity.Manager;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "logs")
public class Log {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY) // 일정 id
	@JoinColumn(name = "manager_id", nullable = false)
	private Manager manager;

	@Column(nullable = false)
	private Boolean isFailed;

	@Column(nullable = false)
	private LocalDateTime time;

	public Log(Manager manager, Boolean isFailed) {
		this.manager = manager;
		this.isFailed = isFailed;
		this.time = LocalDateTime.now();
	}
}