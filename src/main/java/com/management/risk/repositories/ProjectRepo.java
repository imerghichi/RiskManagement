package com.management.risk.repositories;


import com.management.risk.models.Identification.Project;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "projects", path = "projects")
public interface ProjectRepo extends Neo4jRepository<Project,Long> {

}
