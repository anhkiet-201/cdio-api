package com.anhkiet.cdio4_api.model

import com.anhkiet.cdio4_api.dto.ProjectDTO

class ProjectResponseModel(
    val items: List<ProjectDTO>
) : BaseDataResponseModel(true, "")