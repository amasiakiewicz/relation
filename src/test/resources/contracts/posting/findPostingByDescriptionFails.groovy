package contracts.posting

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return posting by description=olo"

    request {
        url "/postings/molo"
        method GET()
    }

    response {
        status NOT_FOUND()
        body(
                errors: [
                        code: "posting.notFound",
                        message: "Posting was not found"
                ]
        )
    }
}
