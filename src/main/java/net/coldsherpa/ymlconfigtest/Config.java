package net.coldsherpa.ymlconfigtest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.LinkedList;
import java.util.Map;
import java.util.stream.Collectors;


@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "attributes")
public class Config {

    private Map<String, Map<Integer, AttributeLink>> links;

    private Logger logger = LoggerFactory.getLogger(Config.class);

    @PostConstruct
    private void init() {
        for (String attr : links.keySet()) {
            for (Integer tier : links.get(attr).keySet()) {
                logger.info("\n" + attr + " tier " + tier + ":\n"+ links.get(attr).get(tier).toString());
            }
        }
    }

    public Map<String, Map<Integer, AttributeLink>> getLinks() {
        return this.links;
    }

    public void setLinks(Map<String, Map<Integer, AttributeLink>> links) {
        this.links = links;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    public static class AttributeLink {
        private UserRank rank;
        private Integer group;
        private LinkedList<Long> roleIds;

        public AttributeLink() {

        }

        @Override
        public String toString() {
            return String.format(
                    "Rank: %s\nGroup: %s\nRoles: %s",
                    rank != null ? rank.getLiteral() : "null",
                    group != null ? group.toString() : "null",
                    roleIds != null ? String.join(",", roleIds.stream().map(Object::toString)
                            .collect(Collectors.toList())) : "null"
            );
        }

        public UserRank getRank() {
            return this.rank;
        }

        public Integer getGroup() {
            return this.group;
        }

        public LinkedList<Long> getRoleIds() {
            return this.roleIds;
        }

        public void setRank(UserRank rank) {
            this.rank = rank;
        }

        public void setGroup(Integer group) {
            this.group = group;
        }

        public void setRoleIds(LinkedList<Long> roleIds) {
            this.roleIds = roleIds;
        }
    }
}