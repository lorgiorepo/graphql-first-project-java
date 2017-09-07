package com.lorgiolab.graphqlserver;

import com.coxautodev.graphql.tools.SchemaParser;
import com.lorgiolab.graphqlserver.query.Mutation;
import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLServlet;
import com.lorgiolab.graphqlserver.query.Query;
import com.lorgiolab.graphqlserver.repository.LinkRepository;

import javax.servlet.annotation.WebServlet;

/**
 * Created by lorgiotrinidad on 02-09-17.
 */
/**
 * The servlet acting as the GraphQL endpoint
 */
@WebServlet(urlPatterns = "/graphql")
public class GraphQLEndpoint extends SimpleGraphQLServlet {

    public GraphQLEndpoint() {
        super(buildSchema());
    }

    private static GraphQLSchema buildSchema() {
        LinkRepository linkRepository = new LinkRepository();
        return SchemaParser.newParser()
            .file("schema.graphql")
            .resolvers(new Query(linkRepository), new Mutation(linkRepository))
            .build()
            .makeExecutableSchema();
    }

}
