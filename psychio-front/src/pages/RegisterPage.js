import { useFormik } from 'formik';
import * as Yup from 'yup';
import { toast } from 'react-toastify';
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import moment from 'moment'
import UserService from '../services/UserService';

const validationSchema = Yup.object({

    username: Yup.string()
        .required('Required')
        .matches('^[a-zA-Z]{0,25}$', 'Invalid input'),
    password: Yup.string()
        .required('Required')
        .matches('^[a-zA-Z]{0,25}$', 'Invalid input'),
    firstName: Yup.string()
        .required('Required')
        .matches('^[a-zA-Z]{0,25}$', 'Invalid input'),
    lastName: Yup.string()
        .required('Required')
        .matches('^[a-zA-Z]{0,25}$', 'Invalid input'),
    birthDate: Yup.date()
        .required('Required'),
    gender: Yup.mixed().oneOf(['MALE', 'FEMALE'])
        .required('Required'),
    maritalStatus: Yup.mixed().oneOf(['SINGLE', 'MARRIED', 'WIDOWED', 'DIVORCED', 'SEPARATED'])
        .required('Required'),
    employmentStatus: Yup.mixed().oneOf(['WORKER', 'SELF_EMPLOYED', 'EMPLOYEE', 'UNEMOLOYED', 'STUDENT'])
        .required('Required'),

});


const RegisterPage = () => {

    const formik = useFormik({
        initialValues: {
            username: '',
            password: '',
            firstName: '',
            lastName: '',
            birthDate: moment().format("YYYY-MM-DD"),
            gender: 'MALE',
            maritalStatus: 'SINGLE',
            employmentStatus: 'WORKER'
        },
        validationSchema: validationSchema,
        onSubmit: (values) => {
            console.log(values);
            UserService.register(values).then((response) => {
                toast.success('Successful registration.');
                formik.resetForm();
                console.log(response);
            });
        },
    });


    return (
        <div>
            <h1>Registration</h1>
            <Form onSubmit={formik.handleSubmit}>
                <Row className="mb-3 mt-5">
                    <Form.Group as={Col} md="4" className="offset-2">
                        <Form.Label>First name:</Form.Label>
                        <Form.Control
                            id="first-name"
                            name="firstName"
                            type="text"
                            value={formik.values.firstName}
                            onChange={formik.handleChange}
                        />
                        {formik.touched.firstName && formik.errors.firstName && (
                            <small className="form-text text-danger">{formik.errors.firstName}</small>
                        )}
                    </Form.Group>
                    <Form.Group as={Col} md="4">
                        <Form.Label>Last name:</Form.Label>
                        <Form.Control
                            id="last-name"
                            name="lastName"
                            type="text"
                            value={formik.values.lastName}
                            onChange={formik.handleChange}
                        />
                        {formik.touched.lastName && formik.errors.lastName && (
                            <small className="form-text text-danger">{formik.errors.lastName}</small>
                        )}
                    </Form.Group>
                </Row>
                <Row className="mb-3 mt-5">
                    <Form.Group as={Col} md="4" className="offset-2">
                        <Form.Label>Username:</Form.Label>
                        <Form.Control
                            id="username"
                            name="username"
                            type="text"
                            value={formik.values.username}
                            onChange={formik.handleChange}
                        />
                        {formik.touched.username && formik.errors.username && (
                            <small className="form-text text-danger">{formik.errors.username}</small>
                        )}
                    </Form.Group>
                    <Form.Group as={Col} md="4">
                        <Form.Label>Password:</Form.Label>
                        <Form.Control
                            id="password"
                            name="password"
                            type="password"
                            value={formik.values.password}
                            onChange={formik.handleChange}
                        />
                        {formik.touched.password && formik.errors.password && (
                            <small className="form-text text-danger">{formik.errors.password}</small>
                        )}
                    </Form.Group>
                </Row>
                <Row className="mb-3 mt-5">
                    <Form.Group as={Col} md="4" className="offset-2">
                        <Form.Label>Gender:</Form.Label>
                        <Form.Select>
                            <option value="MALE">Male</option>
                            <option value="FEMALE">Female</option>
                        </Form.Select>
                        {formik.touched.gender && formik.errors.gender && (
                            <small className="form-text text-danger">{formik.errors.gender}</small>
                        )}
                    </Form.Group>
                    <Form.Group as={Col} md="4" >
                        <Form.Label>Marital status:</Form.Label>
                        <Form.Select>
                            <option value="SINGLE">Single</option>
                            <option value="MARRIED">Married</option>
                            <option value="WIDOWED">Widowed</option>
                            <option value="DIVORCED">Divorced</option>
                            <option value="SEPARATED">Separated</option>
                        </Form.Select>
                        {formik.touched.maritalStatus && formik.errors.maritalStatus && (
                            <small className="form-text text-danger">{formik.errors.maritalStatus}</small>
                        )}
                    </Form.Group>
                </Row>
                <Row className="mb-3 mt-5">
                    <Form.Group as={Col} md="4" className="offset-2">
                        <Form.Label>Date of birth:</Form.Label>
                        <Form.Control
                            id="birthDate"
                            name="birthDate"
                            type="date"
                            value={formik.values.birthDate}
                            onChange={formik.handleChange}
                        />
                        {formik.touched.birthDate && formik.errors.birthDate && (
                            <small className="form-text text-danger">{formik.errors.birthDate}</small>
                        )}
                    </Form.Group>
                    <Form.Group as={Col} md="4" >
                        <Form.Label>Employment status:</Form.Label>
                        <Form.Select>
                            <option value="WORKER">Worker</option>
                            <option value="SELF_EMPLOYED">Self employed</option>
                            <option value="EMPLOYEE">Employee</option>
                            <option value="UNEMOLOYED">Unemployed</option>
                            <option value="STUDENT">Student</option>
                        </Form.Select>
                        {formik.touched.employmentStatus && formik.errors.employmentStatus && (
                            <small className="form-text text-danger">{formik.errors.gender}</small>
                        )}
                    </Form.Group>
                </Row>

                <Button variant="success" type="submit">
                    Create
                </Button>
            </Form>
        </div>
    );
};

export default RegisterPage;