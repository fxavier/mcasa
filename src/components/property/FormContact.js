import Link from "next/link";
import React from "react";

const FormContact = () => {
  return (
    <form className="form-style1">
      <div className="row">
        <div className="col-lg-12">
          <div className="mb20">
            <input
              type="text"
              className="form-control"
              placeholder="Seu Name"
              required
            />
          </div>
        </div>
        {/* End .col-12 */}

        <div className="col-lg-12">
          <div className="mb20">
            <input
              type="text"
              className="form-control"
              placeholder="Telefone"
              required
            />
          </div>
        </div>
        {/* End .col-12 */}

        <div className="col-md-12">
          <div className="mb20">
            <input
              type="email"
              className="form-control"
              placeholder="Email"
              required
            />
          </div>
        </div>
        {/* End .col-12 */}

        <div className="col-md-12">
          <div className="mb10">
            <textarea
              cols={30}
              rows={4}
              placeholder="Há muitas variações de passagens."
              defaultValue={""}
              required
            />
          </div>
        </div>
        {/* End .col-12 */}

        <div className="col-md-12">
          <div className="d-grid">
            <button type="submit" className="ud-btn btn-thm mb15">
              Envia Mensagem
              <i className="fal fa-arrow-right-long" />
            </button>
            <Link className="ud-btn btn-white2" href="/contact">
              Ligar
              <i className="fal fa-arrow-right-long" />
            </Link>
          </div>
        </div>
        {/* End .col-12 */}
      </div>
    </form>
  );
};

export default FormContact;
