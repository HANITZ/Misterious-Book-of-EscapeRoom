package com.sinbangsa.service;


import com.sinbangsa.data.dto.ArticleDto;
import com.sinbangsa.data.entity.Article;
import com.sinbangsa.data.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    final ArticleRepository articleRepository;

    @Transactional
    public boolean createArticle(ArticleDto articleDto) {
        Article article = new Article();

        try {
            article.setHead(articleDto.getHead());
            article.setTitle(articleDto.getTitle());
            article.setContent(articleDto.getContent());
            article.setCreated_at(LocalDateTime.now());
            // jwt토큰 완료 후 articleUser 넣어야함

        } catch (Exception e) {
            return false;
        }
        return true;

    }


}
