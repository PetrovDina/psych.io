import { toast } from "react-toastify";

const errorHandler = (errorResponse) => {
    if (!errorResponse) {
        toast.error("The server is unavailable.");
        return;
    }
    let message = errorResponse.data;
    console.log(message);
    if (errorResponse.data.message) {
        message = errorResponse.data.message;
    } else if (errorResponse.data.accessToken) {
        message = errorResponse.data.accessToken;
    }
    switch (errorResponse.status) {
        case 400:
            toast.error("Bad request - " + message);
            break;

        case 401:
            toast.error("Unauthorized - " + message);
            break;

        case 403:
            toast.error(
                "Forbidden - The client did not have permission to access the requested resource."
            );
            break;

        case 404:
            toast.error("Not found - " + message);
            break;

        case 500:
            toast.error(message);
            break;

        case 503:
            toast.error("The server was unavailable.");
            break;

        default:
            toast.error("Something wrong");
            break;
    }
};

export default errorHandler;
