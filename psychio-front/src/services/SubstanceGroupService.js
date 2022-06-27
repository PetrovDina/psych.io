import httpClient from "../config/httpClient.js";

const SubstanceGroupService = {
    getAll: function () {
        return httpClient({
            url: "substance-groups/all",
            method: "GET",
        });
    },

    getAllTherapies: function () {
        return httpClient({
            url: "therapy/all",
            method: "GET",
        });
    },

    getAllTherapiesByDiagnosis: function (diagnosisId) {
        return httpClient({
            url: "therapy/allByDiagnosis",
            method: "GET",
            params:{diagnosisId}
        });
    },
};

export default SubstanceGroupService;
