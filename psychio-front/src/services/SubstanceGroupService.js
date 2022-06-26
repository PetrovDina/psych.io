import httpClient from "../config/httpClient.js";

const SubstanceGroupService = {
    getAll: function () {
        return httpClient({
            url: "substance-groups/all",
            method: "GET",
        });
    },
};

export default SubstanceGroupService;
