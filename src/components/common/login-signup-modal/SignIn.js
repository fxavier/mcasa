import Link from "next/link";
import React from "react";

const SignIn = () => {
  return (
    <form className="form-style1">
      <div className="mb25">
        <label className="form-label fw600 dark-color">Email</label>
        <input
          type="email"
          className="form-control"
          placeholder="Enter Email"
          required
        />
      </div>
      {/* End email */}

      <div className="mb15">
        <label className="form-label fw600 dark-color">Senha</label>
        <input
          type="text"
          className="form-control"
          placeholder="Enter Password"
          required
        />
      </div>
      {/* End Password */}

      <div className="checkbox-style1 d-block d-sm-flex align-items-center justify-content-between mb10">
        <label className="custom_checkbox fz14 ff-heading">
          Lembra me
          <input type="checkbox" defaultChecked="checked" />
          <span className="checkmark" />
        </label>
        <a className="fz14 ff-heading" href="#">
          Esqueceste sua Senha?
        </a>
      </div>
      {/* End  Lost your password? */}

      <div className="d-grid mb20">
        <button className="ud-btn btn-thm" type="submit">
          Sign in <i className="fal fa-arrow-right-long" />
        </button>
      </div>
      {/* End submit */}

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
        Não entrou?{" "}
        <Link className="dark-color fw600" href="/register">
          Cria a sua conta.
        </Link>
      </p>
    </form>
  );
};

export default SignIn;
