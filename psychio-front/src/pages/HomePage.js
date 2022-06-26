const HomePage = ({loggedUser}) => {
    return (
      <div>
        <h1>Welcome to psych.io
            {loggedUser.username !== "" && (
                ", " + loggedUser.username
            )}
        </h1>
      </div>
    );
  };
  
  export default HomePage;