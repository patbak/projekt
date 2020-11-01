package com.example.projekt.model.projections;

import com.example.projekt.model.ConstructionSite;
import com.example.projekt.model.DailyWorkReport;
import com.example.projekt.model.User;
import org.springframework.data.rest.core.config.Projection;

import java.sql.Date;

@Projection(name = "constructionSiteDetail", types = {ConstructionSite.class})
public interface ConstructionSiteDetail {

    String getName();
    String getDescription();
    User getUser();
    DailyWorkReport getDailyWorkReport();
    Date getPlannedEndDate();

}
