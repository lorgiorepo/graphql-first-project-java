package com.lorgiolab.graphqlserver.query;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import com.lorgiolab.graphqlserver.repository.LinkRepository;

import java.util.List;

/**
 * Created by lorgiotrinidad on 02-09-17.
 */
public class Query implements GraphQLRootResolver {

    private final LinkRepository linkRepository;

    public Query(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    public List<Link> allLinks() {
        return linkRepository.getAllLinks();
    }
}
