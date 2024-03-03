import Link from "next/link";

const SignUp = () => {
  return (
    <form className="form-style1">
      <div className="mb25">
        <label className="form-label fw600 dark-color">Email</label>
        <input
          type="email"
          className="form-control"
          placeholder="Seu Email"
          required
        />
      </div>
      {/* End Email */}

      <div className="mb20">
        <label className="form-label fw600 dark-color">Senha</label>
        <input
          type="text"
          className="form-control"
          placeholder="Sua Senha"
          required
        />
      </div>
      {/* End Password */}

      <div className="d-grid mb20">
        <button className="ud-btn btn-thm" type="submit">
          Cria a sua conta <i className="fal fa-arrow-right-long" />
        </button>
      </div>
      <div className="hr_content mb20">
        <hr />
        <span className="hr_top_text">OU</span>
      </div>

      <div className="d-grid mb10">
        <button className="ud-btn btn-white" type="button">
          <i className="fab fa-google" /> Continue no Google
        </button>
      </div>
      <div className="d-grid mb10">
        <button className="ud-btn btn-fb" type="button">
          <i className="fab fa-facebook-f" /> Continue no Facebook
        </button>
      </div>
      <div className="d-grid mb20">
        <button className="ud-btn btn-apple" type="button">
          <i className="fab fa-apple" /> Continue na Apple
        </button>
      </div>
      <p className="dark-color text-center mb0 mt10">
        Ja tem a conta?{" "}
        <Link className="dark-color fw600" href="/login">
          Entrar
        </Link>
      </p>
    </form>
  );
};

export default SignUp;
