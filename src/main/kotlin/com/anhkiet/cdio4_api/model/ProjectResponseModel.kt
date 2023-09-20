package com.anhkiet.cdio4_api.model

import com.anhkiet.cdio4_api.dto.ProjectDTO

class ProjectResponseModel(
    status: Boolean,
    val project: ProjectDTO?
) : BaseDataResponseModel(status, "")