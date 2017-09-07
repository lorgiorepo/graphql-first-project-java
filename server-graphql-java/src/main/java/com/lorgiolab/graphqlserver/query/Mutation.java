package com.lorgiolab.graphqlserver.query;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import com.lorgiolab.graphqlserver.repository.LinkRepository;

/**
 * Created by lorgiotrinidad on 07-09-17.
 */
public class Mutation implements GraphQLRootResolver {

    private final LinkRepository linkRepository;

    public Mutation(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    public Link createLink(String url, String description) {
        Link newLink = new Link(url, description);
        linkRepository.saveLink(newLink);
        return newLink;
    }
}
