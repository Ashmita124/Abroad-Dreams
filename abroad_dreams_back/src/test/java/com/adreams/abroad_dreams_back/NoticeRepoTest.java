package com.adreams.abroad_dreams_back;

import com.adreams.abroad_dreams_back.entity.Notice;
import com.adreams.abroad_dreams_back.pojo.NoticePojo;
import com.adreams.abroad_dreams_back.repo.NoticeRepo;
import com.adreams.abroad_dreams_back.service.impl.NoticeServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.Optional;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class NoticeRepoTest {

    @Mock
    private NoticeRepo noticeRepo;

    @InjectMocks
    private NoticeServiceImpl noticeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @Order(1)
    public void getNoticeByIdTest() {
        // Given
        Long id = 1L;
        Notice notice = new Notice();
        notice.setNoticeId(id);
        notice.setDate(new Date());
        notice.setTitle("Test Title");
        notice.setDescription("Test Description");

        Mockito.when(noticeRepo.findById(id)).thenReturn(Optional.of(notice));

        // When
        Optional<Notice> result = noticeService.getById(id);

        // Then
        Assertions.assertThat(result).isPresent();
        Assertions.assertThat(result.get().getNoticeId()).isEqualTo(id);
    }

    @Test
    @Order(2)
    public void deleteNoticeByIdTest() {
        // Given
        Long id = 1L;

        // When
        try {
            noticeService.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Then
        Mockito.verify(noticeRepo, Mockito.times(1)).deleteById(id);
    }
}